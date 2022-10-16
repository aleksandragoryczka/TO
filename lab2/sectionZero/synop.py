from helpers import synopDictionary as sd
from sectionZero import date

class Synop():
    def __init__(self, lineNumber, length, content):
        self.date = date.Date.returnDate(length, content)[lineNumber]