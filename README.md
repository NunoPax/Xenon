# Xenon
Vertical shooter Video-Game.

All new EnemyShip(s) and Projectile(s) should be acquired via the *Factory so so objects can be reused.

The Game's main loop is in the Game class's run method. While the game is still running it will in turn call the methods for updating GameObject(s) positions, and calling the CollisionDetector. 


Todo:
-
[x] Project Skeleton

[X] Draw Screen

[X] Draw Player Ship
(PlayerShip, GameMap)

[x] PlayerShip movement

[_] Game class - André

[_] Implement EnemyShipFactory
(EnemyShipFactory, EnemyShip) - Gabriela

[_] Implement EnemyShip(s)
(EnemyShip, GameMap) - André

[_] Implement Projectile(s)
(Projectile) - Julio

[_] Implement ProjectileFactory
(ProjectileFactory, Projectile) - Gabriela

[_] Ship(s) can shoot projectiles
(SpaceShip, ProjectileFactory, Game) - Julio

[_] Implement CollisionDetection
(CollisionDetector, GameObject, SpaceShip) - Nuno

[_] Gain points for destroying EnemyShip(s)
(Game, EnemyShip, PlayerShip, CollisionDetector) - Nuno

[_] Implement obstacles
(new class)

[_] Implement Power Ups
(new class)