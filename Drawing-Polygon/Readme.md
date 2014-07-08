Drawing Polygon
==============

A polygon is a multisided closed figure; a polyline is a line with an arbitrary number of segments. Both polygons and polylines are defined by a set of points, and Java provides graphics methods for both that are based on arrays.

Modify *DrawPerson.java* as follows:

1. Draw the pants and the shirt. Declare pantsX and pantsY arrays like the shirtX and shirtY arrays. Use the paint method draw the pants as well as the shirt.
2. Draw a head (either a circle or an oval). Declare variables headX and headY to hold the position of the head, and use them when you draw the circle.
3. Draw hair on the head using a polygon Use two arrays to hold the points.
4. Draw a zigzag across the front of the shirt. Use a polyline.
5. Write a method `movePerson(int x, int y)` that moves the person by the given number of pixels in the x and y direction.
6. Put a loop in the paintComponent method that draws the person three times, moving the figure by 150 pixels each time.
