Create 3 classes: SpaceShip, Asteroid and SpaceShipGame. In the game, the user shall control the spaceship with the mouse and fires laser at the asteroids.

SpaceShip:

1. The ship is set to an initial coordinates xPos and yPos of 0, 0.
2. The attribute shooting is a boolean depending if the mouse button is pressed. Change the value of shooting via the setShooting method.
3. move() updates the xPos and yPos attributes.
4.draw() must have the same Graphics and the width of the JPAnel so that the laser can shoot from the ship the edge of the screen.

Asteroid:

1. The asteroid is set to an initial xPos equivalent to the width of the panel, and yPos to a random number between 0 and the height of the panel.
2. move() updates the x position of the asteroid.
3. draw() must have the same Graphics.

SpaceShipGame:

1. Extends JPanel and implements multiple Listensers.
2. Creates the spaceship and the laser beam, updates the ship's position.
3. Creates at least 5 asteroids, and create a new asteroid when one leaves the screen.
4. Updates the score of asteroid-ship collisions, hits by the laser, and time remaining in the game.
5. End the game after 10 seconds or 3 collisions.
