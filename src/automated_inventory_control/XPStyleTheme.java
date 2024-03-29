/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automated_inventory_control;

import javax.swing.plaf.metal.MetalTheme;

/**
 *
 * @author ndemo
 */
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class XPStyleTheme extends DefaultMetalTheme {

    public String getName() { return "XP Style Theme"; }

    private final ColorUIResource primary1 = new ColorUIResource( 119,  119,  187); //Frame Border Color
    private final ColorUIResource primary2 = new ColorUIResource( 153,  153,  204); //Barckground Color
    private final ColorUIResource primary3 = new ColorUIResource(225, 225, 255); // Title Color

    private final ColorUIResource secondary1 = new ColorUIResource( 172, 168, 153);  // Shadow color
    private final ColorUIResource secondary2 = new ColorUIResource(172, 168, 153); //Dark Shadow color 113, 111, 100
    private final ColorUIResource secondary3 = new ColorUIResource(236, 233,216); //Face Color

    protected ColorUIResource getPrimary1() { return primary1; }
    protected ColorUIResource getPrimary2() { return primary2; }
    protected ColorUIResource getPrimary3() { return primary3; }

    protected ColorUIResource getSecondary1() { return secondary1; }
    protected ColorUIResource getSecondary2() { return secondary2; }
    protected ColorUIResource getSecondary3() { return secondary3; }

}
