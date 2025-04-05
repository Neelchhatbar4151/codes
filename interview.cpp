#include<bits/stdc++.h>
using namespace std;

int main(){
    int N, K;
    cin >> N >> K;
    
    // int itemLen = 0;
    // cin >> itemLen ;
    
    vector<string> items = {"500:Electronics", "400:Electronics", "300:Sports", "200:Sports","100:Kitchenware"};
    multimap<int, string> mp;
    map<string, int> freq;
    for(int i=0;i<items.size();i++){
        string item = items[i];
        
        string price = "";
        int l = 0;
        for( l =0;l<item.size();l++){
            if(item[l] == ':'){
                break;
            }
        }
        price = item.substr(0, l+1);
        
        int p = stoi(price);
        int t = item.size();
        string cat = item.substr(l+1, t-l);
        mp.insert({p, cat});
        freq[cat] = 0;
    }

    int profit = 0;
    auto last = mp.end();
    last--;
    while(N--){
        if(mp.empty()){
            break;
        }
        if(freq[last->second]<K){
            freq[last->second]++;
            profit += last->first;
        }
        else{
            N++;
        }
        last--;
    }

    cout << profit << endl;
    
    return 0;
}

