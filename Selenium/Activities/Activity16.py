class Car:
    "This class represents Car"
    def __init__(self,manufacturer, model, make, transmission, color):
        self.manufacturer=manufacturer
        self.model=model
        self.make=make
        self.transmission=transmission
        self.color=color

    def accelerate(self):
        print(self.manufacturer+" "+self.model+" is moving")

    def stop(self):
        print(self.manufacturer+" "+self.model+" has stopped")

	
car1 = Car("Kia", "Sonet", "2022", "Semi-Automatic", "Red")
car2 = Car("Tata", "Nexon", "2023", "Automatic", "Black")
car3 = Car("Hyundai", "Creta", "2025", "Manual", "White")
 
car1.accelerate()
car1.stop()

car2.accelerate()
car2.stop()

car3.accelerate()
car3.stop()