/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagame;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


/**
 *
 * @author sperldo
 */
public class RenderHandler {
    
    private BufferedImage view;
    private int[] pixels;
    
    public RenderHandler(int width, int height) {
        
        view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
        
    }
    
    public void render(Graphics graphics) {
        
        int itt = 0;
        for(int index = 0; index < view.getHeight(); index++) {
            int color = (int) (Math.random() * 0xFFFFFF);
            
            for(int ind2 = 0; ind2 < view.getWidth(); ind2++) {
                               
            pixels[ind2+ (itt*view.getWidth())] = color;
            }
            itt++;
        }
        
        graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
    }
    
}
