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
    soup = BeautifulSoup(response.text, "html.parser")

    # Encontre os elementos HTML que contêm os títulos de notícias e suas categorias
    articles = soup.find_all("div", class_="gs-c-promo")

    # Cria arquivo csv
    file = open('export_data2.csv', 'w', newline='', encoding='utf-8')
    writer = csv.writer(file)
    headers = ['Categoria', 'Noticia']
    writer.writerow(headers)

    # Loop pelos elementos e imprimir as categorias e os títulos
    for article in articles:
        category_element = article.find("a", class_="gs-c-section-link")
        category = category_element.text.strip() if category_element else "N/A"
        
        headline_element = article.find("h3", class_="gs-c-promo-heading__title")
        headline = headline_element.text.strip() if headline_element else "N/A"
        
        print(f"Categoria: {category}\nNotícia: {headline}\n")

        # Salvar categoria e notícia no arquivo CSV
        row = [category, headline]
        writer.writerow(row)

    file.close()

else:
    print("Falha ao acessar a página:", response.status_code)