from sectionzero.Date import *
from sectionzero.WindIndicator import *
from sectionzero.InternationalLandStationIndicator import *

class ZeroCollection():
    def __init__(self):
        self.date = Date().return_date()
        self.wind_indicator = WindIndicator().return_wind_indicator()
        self.international_land_station_indicator = InternationalLandStationIndicator().return_international_land_station_indicator()