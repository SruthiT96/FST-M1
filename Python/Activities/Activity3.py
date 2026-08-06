player1=input("player1 enter your name: ")
player2=input("player2 enter your name: ")
print(player1+" "+player2)

player1_answer=input(player1+" Enter your choice");
player2_answer=input(player1+" Enter your choice");

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