/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.lang.Runnable;
import javax.swing.JFrame;


/**
 *
 * @author sperldo
 */
public class JavaGame extends JFrame implements Runnable {

    private Canvas canvas = new Canvas();
    private RenderHandler renderer;
    
    public JavaGame() {
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setBounds(0,0,1000,800);
        
        setLocationRelativeTo(null);
        
        add(canvas);
        
        setVisible(true);
        
        canvas.createBufferStrategy(3);
        
        renderer = new RenderHandler(getWidth(), getHeight());
        
        
    }
    
    public void update() {
        
        
    }
    
    
    public void render() {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();
        super.paint(graphics);
        
        renderer.render(graphics);
        
        graphics.dispose();
        bufferStrategy.show();
        
    }
    
    public void run() {
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        int i = 0;
        int x = 0;
        
        Long lastTime = System.nanoTime();
        double nanoSecondConversion = 1000000000.0 / 60;
        double changeInSeconds = 0;
        
        while(true) {
            
            Long now = System.nanoTime();
            
            changeInSeconds += (now - lastTime) / nanoSecondConversion;
            while(changeInSeconds >= 1) {
                update();
                changeInSeconds = 0;
            }
            
            render();
            lastTime = now;
        }
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JavaGame game = new JavaGame();
        Thread gameThread = new Thread(game);
        gameThread.start();
        
    }
    
}
