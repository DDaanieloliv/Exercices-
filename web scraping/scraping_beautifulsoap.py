import csv
import requests
from bs4 import BeautifulSoup

# URL da página que queremos fazer scraping
url = "https://www.bbc.com/news"

# Conexão: Enviar uma solicitação GET para a URL
response = requests.get(url)

# Verificar se a solicitação foi bem-sucedida (status 200)
if response.status_code == 200:
    # Parse a página com o BeautifulSoup
    #O parser é um analisador sintático. 
    #Sua função é ler uma entrada de dados que possuem certas regras específicas
    soup = BeautifulSoup(response.text, "html.parser")

    # Encontre os elementos HTML que contêm os títulos de notícias
    headlines = soup.find_all("h3", class_="gs-c-promo-heading__title")

    #cria arquivo csv
    #Os parâmetros que vamos utilizar da função open() são: file, mode. 
    #File é o path do arquivo, ou seja, o caminho onde ele está ou será criado.
    # O mode é o modo como o arquivo será aberto, os dois principais modos são 'r' para read(leitura) e 
    # 'w' para writer(escrita).
    file = open('export_data.csv', 'w', newline='')
    writer = csv.writer(file)
    headers = ['Noticias']
    writer.writerow(headers)

    # Loop pelos elementos e imprimir os títulos
    for headline in headlines:
        print(headline.text)
        #cada noticia
        noticia = [headline.text]

        #salvar noticia no arquivo
        file = open('export_data.csv', 'a', newline='', encoding='utf-8')
        writer = csv.writer(file)
        writer.writerow(noticia)
        file.close()

else:
    print("Falha ao acessar a página:", response.status_code)
