
decoder:
	g++ -std=c++11 decoding/302decoder.cpp -o decoding/dec

dump:
	gcc dataAcquisition/usbdump.c -o dataAcquisition/usbdump

all:
	g++ -std=c++11 decoding/302decoder.cpp -o decoding/dec
	gcc dataAcquisition/usbdump.c -o dataAcquisition/usbdump

clean:
	rm decoding/dec
	rm dataAcquisition/usbdump
	
