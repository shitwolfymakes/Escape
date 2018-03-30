This folder contains the savegame files.

At the beginning of the game, the player is prompted to name their save file.

Save file structure:

<> denotes variable, and contains the name the variable should be read into.
() contains range of possible values if applicable

Each line contains the name of the data the line stores. this MUST be validated before 
	you store the following data. 

<username>.txt
1 username,<username>
2 difficulty,<difficultyLevel(1-3)>
3 points,<points>
4 money,<money>
5 levels_unlocked,<numLevelsUnlocked>
6 upgrades,<value>,<value>,...