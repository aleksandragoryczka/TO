from helpers.ContentHandler import *

class InternationalLandStationIndicator(ContentHandler):
    def __init__(self):
        self.indicators_string = []
        ContentHandler.__init__(self)
        for i in range(self.len-1):
            self.indicators_string.append(self.content[i][7])
    
    def return_international_land_station_indicator(self):
        international_land_station_indicators_dictionary = {}
        for count,line in enumerate(self.indicators_string):
            international_land_station_indicators_dictionary[count] = [line[:2], line[2:]]
        return international_land_station_indicators_dictionary



"""
from sectionzero.Date import *

class WindIndicator(Date):
    def __init__(self):
        self.indicators_string = []
        super().__init__()
        for i in range(self.len-1):
            self.indicators_string.append(self.content[i][6])


    def return_wind_indicator(self):
        wind_indicators_dictionary = {}
        for count,line in enumerate(self.indicators_string):
            wind_indicators_dictionary[count] = line[-1]
        return wind_indicators_dictionary """