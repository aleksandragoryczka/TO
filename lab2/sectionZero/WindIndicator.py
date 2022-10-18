from helpers.ContentHandler import *

class WindIndicator(ContentHandler):
    def __init__(self):
        self.indicators_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.indicators_string.append(self.content[i][6])


    def return_wind_indicator(self):
        wind_indicators_dictionary = {}
        for count,line in enumerate(self.indicators_string):
            wind_indicators_dictionary[count] = line[-1]
        return wind_indicators_dictionary
