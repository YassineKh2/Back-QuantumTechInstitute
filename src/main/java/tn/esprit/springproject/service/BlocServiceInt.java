package tn.esprit.springproject.service;

import tn.esprit.springproject.Entity.Bloc;

import java.util.List;

public interface BlocServiceInt {
Bloc addBloc(Bloc bloc);
Bloc updateBloc(Bloc bloc);
List<Bloc> findAll();
Bloc findById(long idBloc);
void delete(long idBloc);
}
