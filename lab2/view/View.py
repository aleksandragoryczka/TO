
from datetime import datetime

from view.DatesParser import DateParser
from view.ValuesFinder import ValuesFinder



class View():
    def display(self):
        try:
            print("Podaj poczatek przedzialu:")

            b_year = input("Rok: ")
            b_month = input("Miesiac: ")
            b_day = input("Dzien: ")
            b_hour = input("Godzina: ")

            beginning = datetime(year = int(b_year), month=int(b_month), day=int(b_day), hour=int(b_hour))

            print("\n\nPodaj koniec przedzialu:")
            e_year = input("Rok: ")
            e_month = input("Miesiac: ")
            e_day = input("Dzien: ")
            e_hour = input("Godzina: ")

            end = datetime(year = int(e_year), month = int(e_month), day = int(e_day), hour=int(e_hour))

            if end < beginning:
                raise ValueError

            dp = DateParser()
            parsed_keys_list = dp.parse_dates(beginning, end)

            vw = ValuesFinder(parsed_keys_list)
            vw.print_info()

        except ValueError:
            print("Podano niepoprawny zakres dat, spróbuj ponownie.")



    


