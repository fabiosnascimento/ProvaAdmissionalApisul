package org.example;

import org.example.model.Elevador;
import org.example.service.impl.IElevadorServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

       Input input = new Input();

       List<Elevador> elevadores = new ArrayList<>();

       elevadores = input.recebeInputs();

       IElevadorServiceImpl elevador = new IElevadorServiceImpl(elevadores);

       elevador.andarMenosUtilizado();
       elevador.periodoMaiorFluxoElevadorMaisFrequentado();
       elevador.periodoMenorFluxoElevadorMenosFrequentado();
       elevador.periodoMaiorUtilizacaoConjuntoElevadores();

       var percA = elevador.percentualDeUsoElevadorA();
       System.out.println("O percentual do elevador A é de: " + percA);

       var percB = elevador.percentualDeUsoElevadorB();
       System.out.println("O percentual do elevador B é de: " + percB);

       var percC = elevador.percentualDeUsoElevadorC();
       System.out.println("O percentual do elevador C é de: " + percC);

       var percD = elevador.percentualDeUsoElevadorD();
       System.out.println("O percentual do elevador D é de: " + percD);

       var percE = elevador.percentualDeUsoElevadorE();
       System.out.println("O percentual do elevador E é de: " + percE);
    }
}