#include <bits/stdc++.h>
using namespace std;

int main(){

	string wordMatch = "dog";
	vector<string> sentences = {"The cat ran away","A big dog is barking","My log is missing","She has a frog" };

	int n = sentences.size();
	vector<pair<int, int>> score(n);
	for(int i=0;i<sentences.size();i++){
		string sentence = sentences[i];
		sentence.push_back(' ');

		string word = "";
		int matching = 0;
		for(int j=0;j<sentence.size();j++){
			if(sentence[j] == ' '){
				//main logic 

				if(word.size() == wordMatch.size()){
					for(int k=0;k<word.size();k++){
						matching += (word[k] == wordMatch[k]);
					}
				}
				word = "";
			}
			else{
				word.push_back(sentence[j]);
			}
		}
		score[i] = {matching, i};
	}

	sort(score.begin(), score.end());

	for(int i=(int)(score.size())-1;i>=0;i--){
		cout << sentences[score[i].second] << " " << score[i].second<< endl;
	}

	return 0;
}

//Input word = "cat" sentences = ["I love my pet", "A car ran fast", 
// "He bought a hat", "The cat sat on the mat"] 