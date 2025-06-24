package org.mspadaru;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static void runSampleInstructions(LightGrid grid) {
        grid.turnOnLights(new Point(887, 9), new Point(959, 629));
        grid.turnOnLights(new Point(454, 398), new Point(844, 448));
        grid.turnOffLights(new Point(539, 243), new Point(559, 965));
        grid.turnOffLights(new Point(370, 819), new Point(676, 868));
        grid.turnOffLights(new Point(145, 40), new Point(370, 997));
        grid.turnOffLights(new Point(301, 3), new Point(808, 453));
        grid.turnOnLights(new Point(351, 678), new Point(951, 908));
        grid.toggleLights(new Point(720, 196), new Point(897, 994));
        grid.toggleLights(new Point(831, 394), new Point(904, 860));
    }

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        LightGrid binaryGrid = new BinaryLightGrid(1000, 1000);
        runSampleInstructions(binaryGrid);
        System.out.printf("In a binary grid %d lights are on%n", binaryGrid.measureLights());

        LightGrid brightnessGrid = new BrightnessLightGrid(1000, 1000);
        runSampleInstructions(brightnessGrid);
        System.out.printf("In a brightness grid %d lights are on%n", brightnessGrid.measureLights());
    }
}