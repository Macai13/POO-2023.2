from mercantil import Mercantil
from pessoa import Pessoa


def main():
    global userInput
    
    while True:
        line = input()
        print(f"${line}")
        userInput = line.split(" ")

        try:
            menu()
        except Exception as e:
            print(e)


def menu():
    global mercantil
    
    if command("end"):
        exit(0)

    if command("init"):
        mercantil = Mercantil(int(userInput[1]))

    if command("show"):
        print(mercantil)

    if command("chegar"):
        mercantil.chegar(Pessoa(userInput[1]))

    if command("chamar"):
        mercantil.chamar(int(userInput[1]))

    if command("finalizar"):
        mercantil.finalizar(int(userInput[1]))      


def command(command):
    if (command.__eq__(userInput[0])):
        return True
    
    return False


if __name__ == "__main__":
    main() 