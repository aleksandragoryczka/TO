import requests

class DataProvider():
    def __init__(self):
        self.url = requests.get("https://www.ogimet.com/cgi-bin/getsynop?begin=202207270600&end=202207271200&state=Pol")
        self.sections = []
        self.len = 0

    def getData(self):
        lines = self.url.text.split("\n")
        for line in lines:
           self.sections.append(line[line.find(",")+1 : line.find(" 333 ")].replace(" ",",").split(","))
        self.len = len(self.sections)
  #      print(self.sections)
        return self.sections, len(self.sections)