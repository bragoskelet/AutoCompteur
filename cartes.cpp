#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <cmath>

using namespace std;

const double proba_mutation=0.1;
const double proba_crossover=0.5;
const int max_iterations=2000;
const int dimension=10;
const int taille_pop=30;

double randProba()
{
    double r=static_cast<double>(rand()) / RAND_MAX; //entre 0 et 1
    return r+0.0001;
}

void initIndividu(vector<int>& individu)
{
    individu.resize(dimension);
    for(int j=0; j<individu.size(); ++j)
    {
        individu[j]=rand()%2;
    }
}

void initPopulation(vector<vector<int>>& population)
{
    population.reserve(taille_pop);
    population.resize(taille_pop);
    for(int i=0; i<population.size(); ++i)
    {
        initIndividu(population[i]);
    }
}

int f(const vector<int>& individu) //fonction objective
{
    int s=0, p=1;
    for(int i=0; i<individu.size(); ++i)
    {
        if(individu[i]==0) s+=i+1;
        else p*=i+1;
    }

    return (fabs(s-36)+fabs(p-360));
}

/*
void croisement(const vector<int>& base, vector<int>& changed)
{
    int random=rand()%dimension;

    for(int i=random; i<dimension; ++i)
    {
        changed[i]=base[i];
    }
}*/

void croisement(const vector<int>& base, vector<int>& changed, int i)
{
    changed[i]=base[i];
}

void mutation(vector<int>& individu, int i)
{
    //int random=rand()%10;
    individu[i]=1-individu[i];
}

void selectBest(const vector<vector<int>> population, int& best, int& looser)
{
    if(f(population[looser]) < f(population[best])) swap(best,looser);
}

int populationBest(const vector<vector<int>> population)
{
    int best=0;
    for(int i=1; i<population.size(); ++i)
    {
        if(f(population[i]) < f(population[best])) best=i;
    }
    return best;
}

void afficheIndividu(const vector<int>& individu)
{
    int s=0, p=1;
    for(int i=0; i<individu.size(); ++i)
    {
        cout<<individu[i]<<" ";
        if(individu[i]==0) s+=i+1;
        else p*=i+1;
    }
    cout<<"Somme: "<<s<<" /Produit: "<<p;
}

void affichePopulation(const vector<vector<int>>& population)
{
    for(int i=0; i<population.size(); ++i)
    {
        afficheIndividu(population[i]);
        cout<<endl;
    }
}

void messageFin(const vector<vector<int>>& population, int best, int iterations)
{
    int F=f(population[best]);
    cout<<"Termine, "<<iterations<<" iterations\n";
    if(F==0) cout<<"Solution trouvee : f=";
    else cout<<"Solution non-trouvee, optimale : f=";
    cout<<F<<endl;
    afficheIndividu(population[best]);
}


void cartes()
{
    vector<vector<int>> population;
    initPopulation(population);
    //affichePopulation(population);
    int best=rand()%taille_pop;
    //int best=populationBest(population);

    int iterations=0;
    while(iterations<max_iterations && f(population[best])!=0)
    {
        int looser=rand()%taille_pop;
        selectBest(population,best,looser);

        for(int j=0; j<dimension; ++j)
        {
            double p=randProba();
            if(p<proba_crossover)
            {
                croisement(population[best],population[looser],j);
            }

            if(p<proba_mutation)
            {
                mutation(population[looser],j);
            }
        }

        selectBest(population,best,looser);
        ++iterations;
    }

    messageFin(population,best,iterations);

}


int main()
{
    srand (time(NULL));
    for(int i=0; i<5; ++i)
    {
        cartes();
        cout<<endl<<endl;
    }
}
