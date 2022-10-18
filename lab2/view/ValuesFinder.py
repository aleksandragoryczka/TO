from view.ViewHelper import *
from sectionone.OneCollection import *
from sectionzero.ZeroCollection import *
from helpers.SynopDictionary import *
from sectionone.OneCollection import *

class ValuesFinder(ZeroCollection, OneCollection):
    def __init__(self, parsed_keys_list):
        ZeroCollection.__init__(self)
        OneCollection.__init__(self)
        self.parsed_keys_list = parsed_keys_list

    def print_info(self):   
        for key in self.parsed_keys_list:
            print("\n")
            print(self.date[key])
            print("wskaźnik wiatru:\t\t\t\t\t" + specification["windIndicator"][self.wind_indicator[key]])
           
            print("międzynarodowy identyfikator stacji lądowej:\t\t" + "nr blokowy: " + self.international_land_station_indicator[key][0] + 
            ",\tindywidualny nr stacji: " + self.international_land_station_indicator[key][1] + "\n")

            print("wskaźnik grupy opadowej:\t\t\t\t" + specification["rainGroupIndicator"][self.first.return_rain_group_indicator()[key]])
            print("typ stacji:\t\t\t\t\t\t" + specification["stationType"][self.first.return_station_type()[key]])
            print("wysokość względna podstawy najniższych chmur:\t\t" + specification["relativeHeight"][self.first.return_relative_height()[key]])
            print("Widzialność w kierunku poziomym:\t\t\t" + specification["visibility"][self.first.return_visibility()[key]] + "\n")

            print("Wielkość zachmurzenia ogólnego:\t\t\t\t" + specification["cloudyIndicator"][self.second.return_cloudy_indicator()[key]])
            print("średni kierunek wiatru rzeczywsitego:\t\t\t" + specification["windDirection"][self.second.return_wind_direction()[key]])
            print("prędkość wiatru w węzłach:\t\t\t\t" + self.second.return_wind_speed()[key] + "\n")

            print("Temperatura powietrza:\t\t\t\t\t" + self.third.return_air_temperature()[key] + "\n")

            print("Temperatura punktu rosy:\t\t\t\t" + self.fourth.return_dewpoint_temperature()[key] + "\n")

            print("Ciśnienie atmosferyczne na poziomie stacji:\t\t" + self.fifth.return_pressure_station()[key] + "\n")
            
            print("Ciśnienie atmosferyczne na poziomie morza:\t\t" + self.sixth.return_pressure_sea()[key] + "\n")

            print("Charakterystyka tendencji ciśnienienia:\t\t\t" + specification["tendencyAtmosphericPressure"][self.seventh.return_tendency_atmosphere_pressure()[key]])
            print("Bezwzględna wartość tendencji ciśnienia:\t\t" + self.seventh.return_absolute_tendency_atmosphere_pressure()[key] + "\n")

            self.total_percipitation_helper(key)
            self.present_past_weather_helper(key)
            self.clouds_helper(key)


    def total_percipitation_helper(self, key):
        if key in self.eighth.return_total_precipitation("6").keys():
            v = self.eighth.return_total_precipitation("6")[key][1:4]
            v2 = self.eighth.return_total_precipitation("6")[key][4]
            if v in list(specification["totalPrecipitation"].keys()):
                print("Suma opadów:\t\t\t\t\t\t" + specification["totalPrecipitation"][v])
            else:
                print("Suma opadów:\t\t\t\t\t\t" + v.lstrip("0") + " mm")
            print("Czas trwania okresu opadu:\t\t\t\t" + specification["durationOfTheRainfallPeriod"][v2] + "\n")

    def present_past_weather_helper(self, key):
        if key in self.eighth.return_total_precipitation("7").keys():
            v = self.eighth.return_total_precipitation("7")[key][1:3]
            print("Pogoda bieżąca:\t\t\t\t\t\t" + specification["presentWeather"][v])
            v2 = self.eighth.return_total_precipitation("7")[key][3]
            v3 = self.eighth.return_total_precipitation("7")[key][4]
            print("Pogoda ubiegła:\t\t\t\t\t\t" + specification["pastWeather"][v2], end ="")
            if v2 != v3:
                print(specification["pastWeather"][v3])
            print("\n")
    
    def clouds_helper(self, key):
        if key in self.eighth.return_total_precipitation("8").keys():
            v = self.eighth.return_total_precipitation("8")[key][1]
            print("Wielkość zachmurzenia (oktnty):\t\t\t\t" + v)
            v2 = self.eighth.return_total_precipitation("8")[key][2]
            v3 = self.eighth.return_total_precipitation("8")[key][3]
            v4 = self.eighth.return_total_precipitation("8")[key][4]
            print("Opis chmur:")
            print(specification["stratocumulusClouds"][v2])
            print(specification["altocumulusClouds"][v3])
            print(specification["cirrusClouds"][v4])