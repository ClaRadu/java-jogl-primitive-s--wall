##   Java + Jogl Implementation by C.R.Games <cla.radu@crgames.elementfx.com>

# License
Please read the license file to know the conditions in which you can use and/or modify this project.

# Info
  This app was created using Eclipse Oxygen.2. The 1.11+ version of the source code is available.
The purpose of this program is to demonstrate how the Jogl framework can be use with Eclipse, while also 
showing how to create a basic OpenGl cube from multiple faces, then multiplying it to form a 
15 elements (5*3) wall and displaying everything in a OpenGl window, along with text.
'joglcubes' and 'joglcubes/objs' folders contain the source code.

# Setting up project
  First, you'll need to download all libraries you'll need.
So go to:
"http://jogamp.org/", and under "Builds / Downloads", from "Current" select "zip"
Or just go to:
"http://jogamp.org/deployment/jogamp-current/archive/" and download "jogamp-all-platforms.7z"

  Configuring project under Eclipse:
Select 'File' -> 'New' -> 'Java Project'.
Link the new project with the libraries you've just downloaded by right-clicking your project and 
selecting 'Link Path' -> 'Add libraries'. From the poup window select 'User library' and click 'Next'.
Next, select 'User Libraries' from the right side of the popup window, then 'New'. Another popup window 
appears to prompt you to select the library's name, I wrote there 'jogl-2.3.2' because that's the 
version I've used. Now, select 'Add External JARs' and from "jogamp-all-platforms/jar/" and add 
"jogl-all.jar and "gluegen-rt.jar", then click 'Apply and Close'. In the 'Add Library' window select 
your newly created library (jogl-2.3.2 for me) and click 'Finish'.
Now, add the .java file to your project, or copy the source code and make the appropriate changes 
if you've allready created a java file.
In order to run correctly the precompiled jar file will need "gluegen-rt.dll", "jogl_desktop.dll", 
"nativewindow_awt.dll" and "nativewindow_win32.dll", all found in the "jogamp-all-platforms\lib\" folder.
For me it was: "jogl/jogamp-all-platforms/lib/windows-i586/" (on windows 32 bit).

# Credits
  Thanks to NeHe ( http://nehe.gamedev.net/ ) for all the OpenGl tutorials and resources, both for C and Java.

Project full name: 'Java+Jogl Cubes'
Official name: 'Primitive(s) Wall by C.R.G.'
Version: 1.11.0
http://crgames.elementfx.com

C.R.G. 2018
