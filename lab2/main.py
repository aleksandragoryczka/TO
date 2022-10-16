from asyncore import read
from helpers import *
from sectionZero import *

class main():
    dataProvider= DataProvider()
    
    readings = dataProvider.getData()[1]
    sc = SynopCollection(readings, dataProvider.getData()[0])
    #Date(readings, dataProvider.getData()[0]).returnDate()
    #dzis.returnDate()
    

if __name__ == "__main__":
    main()