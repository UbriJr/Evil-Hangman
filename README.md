# Evil-Hangman
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build](https://img.shields.io/badge/Build-passing-<COLOR>.svg)](https://shields.io/)
[![Awesome](https://cdn.rawgit.com/sindresorhus/awesome/d7305f38d29fed78fa85652e3a63e154dd8e8829/media/badge.svg)](https://github.com/sindresorhus/awesome)  

Tested on:
- macOS
- Windows

# About

### Summary
Evil Hangman was a summer long project which required me to master and implement many different tools within Java. This project was meant to make use of all the topics introduced in CMPSC 221 (Object Oriented Programming with Web Applications) in one all encompassing GUI. In a normal game of Hangman, a word is selected at the beginning of the game, with one player guessing a single letter at a time. This is not the case in Evil Hangman. 

If you are unfamiliar with the rules of Hangman, refer to this source:

https://en.wikipedia.org/wiki/Hangman_(game)

In Evil Hangman, a word is not choosen at the beginning of the game, instead, the program tracks the users inputs and responds according, making it more difficult to win. The program can be adjusted to make it easier or more difficult to win. The game provides feedback after each input and warns the player if they are in danger of losing, with each incorrect answer resulting in a subtraction of one life out of the ten given lives the player starts off with. 

The game concludes when either the player guesses all the characters in the "secret word" correctly, or the player continues to guess incorrectly, resulting in their lives reaching 0. 

### Implemented Algorithm 
Evil Hangman utilizes a unique algorithm to play against the user. When the game is launched, a text file containing 9000+ words is read, filtered, and sorted into a list of words. This list is what will be used to find the "secret word". In contrast to a traditional game of Hangman, the "secret word" is not selected from the pool of potentional words until there is only one word remaining in the list. The users inputs are fed into the algorithm, where it checks and removes every word from the list that contains the users input. For example, if the user entered an "A", every word containing an "A" would be removed from the list and the game would display one less life from the available lives given at the start. This continues until only a single word remains in the list, that last word becomes the "secret word" and it is this word that will be stored and used for the remainder of the round. The user can still win by guessing the letters contained in the "secret word", however, by this point the user will likely be down to their last few lives. 

### Additional Features
In addition to the algorithm that removes words from the list if they contain the users input, Evil Hangman contains some features that allow the player to adjust the difficulty of the game, restart or exit the game, aswell as features that increase the games performance. 

The difficulty of the game can be adjusted by changing the amount of allowed lives and the length of the words. The preset settings give the player 10 lives and only add words to the list of potential "secret words" if they are exactly 6 characters in length. This can be changed, and less lives can be given at the beginning of the game while also making the length of the words longer. This makes it increasingly more difficult to win as there is less room for error and forces the player to guess more conservatively. 

Next, while in the main game state, the player has the option to restart or close the game entirely. Pressing the yellow circle at the top left of the panel will empty the recently filled list of words, where program will reread the text file and sort the words back into the list. If any words were previously elimininated, they are returned to the list of words. If a "secret word" had already been selected and was being partially displayed (i.e. C _ _ R _ H), that word would not be returned to the list of potential "secret words" after the restart until the game is exited. By removing words that may have been already seen by the user, dublicate "secret words" are elimianted if the player continues to play more rounds. By pressing the red circle, found directly above the restart circle, the program is terminated and the GUI will close. These features are also seen after each round, giving the player the option to either be returned to the main menu, play another round, or to exit the game. 

Lastly, some features were implemented to increase the performance of the game and overall experience. During testing, ocassionally the program would run slowly, this was determined to be caused by the constant loading and reloading of each panel as the player made their way through the game. To combat this, every panel seen in game is created at the very beginning, when the program is launched, and simply switches between states of visibility. This replaced the earlier implemented model in which the current panel would be created and the previous destroyed, which was inefficient for loading panels containing many buttons, images and action listeners. This new model would only keep the current panel visible while the dormant ones were invisible. This resulted in a seamless transition between panels and improved overall responsiveness. 


### Cloning the Repository

Clone this repository by selecting the green "Code" dropdown button. Then, copy the generated link and open IntelliJ. When you open IntelliJ, at the top there is a "Get from VCS" button, press it. Paste the URL GitHub generated into the "URL:" field, select a directory to store your cloned project and press "Clone" at the bottom. 


### Getting Started 

<p align="center">
<img src= "https://github.com/UbriJr/Evil-Hangman/blob/master/images/run.png" />
</p>

Once you have cloned the repository into IntelliJ, head over to the driver class and press the green arrow near the top of the class, then select "run driver.main()". When you initially clone the repository, IntelliJ won't know which class is the main class nor will it know the configuration, selecting the green arrow and running this class fixes this. 


### Game Demo


<p align="center">
<img src= "https://github.com/UbriJr/Evil-Hangman/blob/master/images/x1.png" />
</p>

The main menu panel shown above is the first panel the player will see after running the program. To continue, the player must press the "Start" button that is in the lower center portion of the panel.



<p align="center">
<img src= "https://github.com/UbriJr/Evil-Hangman/blob/master/images/x2.png" />
</p>

The instruction panel illustrated above is what the player is greeted with after pressing "Start". This panel aims to educated the player on the rules of the game, where to enter their guesses, aswell as some addition features included in the game like the "Restart" and "Close Game" buttons located in the top left corner. Once the player understands the rules, objective and features within the game, they must press "Got It" in order to continue. 



<p align="center">
<img src= "https://github.com/UbriJr/Evil-Hangman/blob/master/images/x3.png" />
</p>

Once the user presses the "Got It" button, they will be brought to the main game panel, where the actual game will take place. Once the player is in this panel, all of their entries and guesses will be recorded and fed into the algorithm. The player will enter their guesses in the square box found in the bottom right corner. If the user enters an entry that isn't valid, such as a number, symbol or special character, the program will return "Invalid Input" in the top right corner. The game will keep track of the lives remaining, which can be found on the top right corner, as well as a list of letters not yet guessed located at the bottom.



<p align="center">
<img src="https://github.com/UbriJr/Evil-Hangman/blob/master/images/x4.png" />
</p>

For each incorrect guess, a life is removed from the total number of lives. Whenever one of the player's lives is removed, a new segment of the stick figure is added to the gallow. Once the entire stick figure is complete the player loses the game. When the player is left with their final life, a message will appear warning the player that they are close to losing.


<p align="center">
<img src="https://github.com/UbriJr/Evil-Hangman/blob/master/images/x5.png" />
</p>

If the player guesses every letter in the "secret word" they will be brought to the win panel. The phrase "You Won!" will display and the "secret word" will be displayed in its entirety will the rescued stick figure will be displayed sitting in the bottom left corner. The player will be given the option to either return to the main menu, play another round or to exit the game.



<p align="center">
<img src="https://github.com/UbriJr/Evil-Hangman/blob/master/images/x6.png" />
</p>

If the player is unable to guess each letter in the "secret word" they will be brought to the lost panel. The phrase "You Lost!" will display and the "secret word" will be displayed in its entirety, a tombstone for the ill-fated stick figure rests in the bottom right corner. The player will be given the option to either return to the main menu, play another round or to exit the game.


