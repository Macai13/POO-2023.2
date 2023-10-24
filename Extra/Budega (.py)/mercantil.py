from pessoa import Pessoa


class Mercantil():
    def __init__(self, qtdCaixas : int):
        self.caixas = [Pessoa("-----")] * qtdCaixas
        self.espera = []


    def __validarIndice(self, indice : int):
        if indice < len(self.caixas):
            return True
        
        raise Exception("fail: indice invalido")
    

    def chegar(self, pessoa : Pessoa):
        self.espera.append(pessoa)


    def chamar(self, indice : int):
        if self.__validarIndice(indice):
            self.caixas.remove(self.caixas[indice])
            self.caixas.insert(indice, self.espera[0])

            self.espera.remove(self.espera[0])


    def finalizar(self, indice : int):
        if not self.__validarIndice(indice):
            return
        

        if self.caixas[indice] == Pessoa("-----"):
            raise Exception("fail: caixa vazio")
        
        self.caixas.remove(self.caixas[indice])
        self.caixas.insert(indice, Pessoa("-----"))

    
    def __str__(self):
        return f"Caixas: {self.caixas}\nEspera: {self.espera}"
    
    
    def __repr__(self):
        return f"Caixas: {self.caixas}\nEspera: {self.espera}"