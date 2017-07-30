/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.awt.Color;
import java.time.LocalDate;

/**
 *
 * @author Wen Yang
 */
public class TaskDurationToRGB {

    public static Color dateToColor(LocalDate targetDate) {
          int r = 255;
        int g = 100;
        int b = 100;
        int maximumDay = 14;
        int daysLeft = Math.abs(targetDate.until(LocalDate.now()).getDays());
        g += ((155 / (maximumDay / 2)) * daysLeft );
        r -= ((155 / (maximumDay / 2)) * ((daysLeft) - (maximumDay / 2)));

        g = g < 100 ? 100 : g;
        g = g > 255 ? 255 : g;
        r = r < 100 ? 100 : r;
        r = r > 255 ? 255 : r;

        return new Color(r, g, b);
    }

  
}
