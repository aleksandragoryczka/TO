

class myinterface(abc.ABC):
    @abc.abstractclassmethod
    def disp(cls):
        pass


class nieabc():
    def zwykla(self):
        print("zwykla metoda")


class myclass(myinterface, nieabc):
    def disp(self):
        print("dispalying")

    def sec(self):
        print("second method")




o = myclass()
o.disp()
o.sec()
o.zwykla()
