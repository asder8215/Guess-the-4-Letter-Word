# Android Project 1 - Guess the 4 Letter Word

Submitted by: Mahdi Ali-Raihan

Guess the 4 Letter Word is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html). 

Time spent: **6** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **User has 3 chances to guess a random 4 letter word**
- [X] **After 3 guesses, user should no longer be able to submit another guess**
- [X] **After each guess, user sees the "correctness" of the guess**
- [X] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle betweeen different word lists
- [X] User can see the 'correctness' of their guess through colors on the word 
- [ ] User sees a visual change after guessing the correct word
- [X] User can tap a 'Reset' button to get a new word and clear previous guesses
- [X] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:

* [X] Force caps lock on EditView input (since the word cannot have a lowercase letter to compare to)

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='=demo.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

<!-- Replace this with whatever GIF tool you used! -->
GIF created with Ezgif  
<!-- Recommended tools:
[Kap](https://getkap.co/) for macOS
[ScreenToGif](https://www.screentogif.com/) for Windows
[peek](https://github.com/phw/peek) for Linux. -->

## Notes

Describe any challenges encountered while building the app.

Restarting the app was one thing that challenged me since I thought I could call the function onCreate() to redo the whole app, but it doesn't work like that. Additionally, retrieving inputs from EditView and checking the guess from the 4 separate TextViews was another challenge (I created my own version of checkGuess() method albeit similar to the one from CodePath).

## License

    Copyright [2022] [Mahdi Ali-Raihan]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
