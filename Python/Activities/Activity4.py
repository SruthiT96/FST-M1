player1=input("player1 enter your name: ")
player2=input("player2 enter your name: ")
print(player1+" "+player2)
while(True):
    player1_answer=input(player1+" Enter your choice").lower()
    player2_answer=input(player1+" Enter your choice").lower()
    if player1_answer==player2_answer:
        print("Same choice, Play again!!")
    elif player1_answer == 'rock':
        if player2_answer == 'scissors':
            print("Rock wins!")
        else:
            print("Paper wins!")
    elif player1_answer == 'scissors':
        if player2_answer == 'paper':
            print("Scissors win!")
        else:
            print("Rock wins!")
    elif player1_answer == 'paper':
        if player2_answer == 'rock':
            print("Paper wins!")
        else:
            print("Scissors win!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")
    wantToPlay=input("Do you want to play again?").lower()
    print(wantToPlay)
    if wantToPlay=="yes":
        continue
    elif wantToPlay=="no":
        break
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit