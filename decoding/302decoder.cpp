// Translate the Wacom USB data
#include <iostream>
#include <iomanip>
#include <string>
#include <stdio.h>
#include <cstring>
#include <vector>
#include <stdlib.h>

#include <algorithm> // for copy
#include <iterator> 

using namespace std;
class decoder302{
	public:
		void parseString(string s);
		void decodeBits();
		void print();
		void Tokenize(const string& str,vector<string>& tokens, const string& delimiters);
		decoder302();
		
	private:
		vector<string> data;
		int prox;
		int pressure;
		int x;
		int y;
		float timeValue;
//	
};
decoder302::decoder302(){
	//char array[8];
	//data=array;
	prox=-1;
	pressure=-1;
	x=-1;
	y=-1;
	timeValue=-1;
}
void decoder302::parseString(string s){
	// parse string into data array
	vector<string> tokens;
	Tokenize(s,tokens," ");

	
	data=tokens;

}
void decoder302::decodeBits(){
	// decode data 
	//iterate through data Array and assign values (staring with time and x/y pos only)

	//split data[4] to decode into x 
	int primaryBits = stoi(data[4].substr(0,2),0,16);
	int secondaryBits = stoi(data[4].substr(2,2),0,16);	
	
	x = (primaryBits | (secondaryBits << 8)) ;
   	
	//split data[5] to decode into y
	primaryBits = stoi(data[5].substr(0,2),0,16);
	secondaryBits = stoi(data[5].substr(2,2),0,16);
	
	y = primaryBits | (secondaryBits << 8) ;

	//parse out time value
	timeValue = stof(data[0]);
}
void  decoder302::print(){
	// print pertinent values
	cout<<dec<<x<<" "<<dec<<y<<" ";
	cout<<timeValue<<endl;	
}
void decoder302::Tokenize(const string& str, vector<string>& tokens, const string& delimiters)
{
    // Skip delimiters at beginning.
    string::size_type lastPos = str.find_first_not_of(delimiters, 0);
    // Find first "non-delimiter".
    string::size_type pos     = str.find_first_of(delimiters, lastPos);

    while (string::npos != pos || string::npos != lastPos)
    {
        // Found a token, add it to the vector.
        tokens.push_back(str.substr(lastPos, pos - lastPos));
        // Skip delimiters.  Note the "not_of"
        lastPos = str.find_first_not_of(delimiters, pos);
        // Find next "non-delimiter"
        pos = str.find_first_of(delimiters, lastPos);
    }
}
int main (void){
	decoder302* d = new decoder302();

	string str;
	while(getline(cin,str)){
		d->parseString(str);
		d->decodeBits();
		d->print();
	}

//example string: // example string 3.007935 1<-- 10: 02e1 6c3a 4824 a403 2c00
//first number is time stamp
//second word is x
//third word is y
}


