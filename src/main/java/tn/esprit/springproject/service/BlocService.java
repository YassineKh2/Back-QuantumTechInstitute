package tn.esprit.springproject.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.springproject.Entity.Bloc;
import tn.esprit.springproject.repository.BlocRepoInt;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlocService implements BlocServiceInt{
    private final BlocRepoInt blocServiceInt;
    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocServiceInt.save(bloc);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocServiceInt.save(bloc);
    }

    @Override
    public List<Bloc> findAll() {
        return (List<Bloc>) blocServiceInt.findAll();
    }

    @Override
    public Bloc findById(long idBloc) {
        return blocServiceInt.findById(idBloc).orElse(null);
    }

    @Override
    public void delete(long idBloc) {
        blocServiceInt.deleteById(idBloc);
    }
}
