# CEG4110-HW1

## Description
This is an application built in android studio. It contains one UI that takes user input text and the text color is randomly changed with the press of a button. The red, green, and blue values for the random color are displayed as well as the html color code for that specific color. The application also contains a second UI that is a simple painting canvas. The user can draw on the screen in any color selected from a color picker. The image can be as saved as a png or jpeg file.

## Operation
The opening UI shows an application with two tabs. The app will already be on the first tab which contains the input text randomizer. The user can type a short message into the text field and then press the "change color" button to randomize its text color. 

![](https://github.com/tylerpalcic/CEG4110-HW1/blob/master/screenshots/hw1_part1_scrsht.png)
![](https://github.com/tylerpalcic/CEG4110-HW1/blob/master/screenshots/hw1_colorpicker_scrsht.png)

Selecting tab 2 at the top of the screen will move the user to a new screen containing the painting canvas. The user can then draw on the screen in black or select the color button to create any color from the entire color spectrum. The drawing can be erased to start over if the user doesn't like their drawing by tapping the "clear canvas" button or they can save the drawing by tapping the "save" button.

![](https://github.com/tylerpalcic/CEG4110-HW1/blob/master/screenshots/hw1_part2_scrnst.png)

## External Libraries
The color picker library used for the drawing canvas is Pes8/android-material-color-picker-dialog which can be found here: 

* https://github.com/Pes8/android-material-color-picker-dialog?utm_source=android-arsenal.com&utm_medium=referral&utm_campaign=5609


You may have to add some packaging options to the build.gradle in order for the project to build once this color picker has been implemented. The ones that I added are here:


This one up top right inside the "android" opening curly-brace.
````
 packagingOptions {
        pickFirst 'lib/armeabi-v7a/libassmidi.so'
        pickFirst 'lib/x86/libassmidi.so'
    }
````

 These two towards the bottom of the file with the other implementations.
 ````
  implementation 'com.pes.materialcolorpicker:library:1.2.4'
  implementation 'com.android.support:design:+'
````

## Software Design

The basic design of this application is two separate fragment classes where the content for each tab is built. An additional class for the pager adapter and another class where the canvas is built. The main class is where the actual tab layout that houses each UI is constructed along with the implementation of the pager adapter.

I chose to design the application in this fashion for a couple of reasons. The first being that I knew that the project was going to need two different tabs in order to switch back and forth from one UI to the other. So I created two new java classes and xml files for each tab fragment. The drawing canvas would then need to be built in a separate class and referenced within the class of the tab using it. I needed a pager adapter in order to switch between each tab so one was built in another class as well. The main class of course is where all the additional built classes are implemented.

## Author
* Tyler Palcic

## Built with
* Android Studio
