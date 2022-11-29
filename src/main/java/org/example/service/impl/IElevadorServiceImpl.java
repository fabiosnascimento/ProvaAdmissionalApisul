package org.example.service.impl;

import org.example.model.Elevador;
import org.example.service.IElevadorService;

import java.util.*;
import java.util.stream.Collectors;

public class IElevadorServiceImpl implements IElevadorService {

    private List<Elevador> elevadores;

    public IElevadorServiceImpl(List<Elevador> elevadores) {
        this.elevadores = elevadores;
    }

    @Override
    public List<Integer> andarMenosUtilizado() {
        List<Integer> andares = new ArrayList<>();
        this.elevadores.forEach(e -> andares.add(e.getAndar()));

        Map<Integer, Integer> contagemAndares = new TreeMap<Integer, Integer>();
        SortedMap<Integer, List<Integer>> frequencias = new TreeMap<Integer, List<Integer>>();

        for(Integer in: andares) {
            int freq = 0;
            if(contagemAndares.containsKey(in)) {
                freq = contagemAndares.get(in);
            }
            contagemAndares.put(in, freq + 1);
        }

        for(Map.Entry<Integer, Integer> entry: contagemAndares.entrySet()) {
            List<Integer> andar = frequencias.get(entry.getValue());
            if (andar == null) {
                andar = new ArrayList<Integer>();
            }
            andar.add(entry.getKey());
            frequencias.put(entry.getValue(), andar);
        }

        System.out.print("\nAndares menos utilizados: ");
        var andaresMenosUtilizados = frequencias.get(frequencias.firstKey());
        andaresMenosUtilizados.forEach(a -> System.out.print(a + " "));

        return andaresMenosUtilizados;
    }

    @Override
    public List<Character> elevadorMaisFrequentado() {
        List<Character> elevadores = new ArrayList<>();
        this.elevadores.forEach(e -> elevadores.add(e.getElevador()));

        Map<Character, Integer> contagemAndares = new TreeMap<Character, Integer>();
        SortedMap<Integer, List<Character>> frequencias = new TreeMap<Integer, List<Character>>();

        for(char in: elevadores) {
            int freq = 0;
            if(contagemAndares.containsKey(in)) {
                freq = contagemAndares.get(in);
            }
            contagemAndares.put(in, freq + 1);
        }

        for(Map.Entry<Character, Integer> entry: contagemAndares.entrySet()) {
            List<Character> elevador = frequencias.get(entry.getValue());
            if (elevador == null) {
                elevador = new ArrayList<Character>();
            }
            elevador.add(entry.getKey());
            frequencias.put(entry.getValue(), elevador);
        }

        //System.out.println("\nElevadores mais frequentados: \n");
        var elevadoresMaisFrequentados = frequencias.get(frequencias.lastKey());
        //elevadoresMaisFrequentados.forEach(a -> System.out.print(a + " "));

        return elevadoresMaisFrequentados;
    }

    @Override
    public List<Character> periodoMaiorFluxoElevadorMaisFrequentado() {
        var elevadorMaisFrequentado = this.elevadorMaisFrequentado().get(0);

        List<Character> periodos = new ArrayList<>();
        var turnos = this.elevadores.stream().filter(e -> e.getElevador() == elevadorMaisFrequentado)
                .collect(Collectors.toList());
        turnos.forEach(e -> periodos.add(e.getTurno()));

        Map<Character, Integer> contagemPeriodos = new TreeMap<Character, Integer>();
        SortedMap<Integer, List<Character>> frequencias = new TreeMap<Integer, List<Character>>();

        for(char in: periodos) {
            int freq = 0;
            if(contagemPeriodos.containsKey(in)) {
                freq = contagemPeriodos.get(in);
            }
            contagemPeriodos.put(in, freq + 1);
        }

        for(Map.Entry<Character, Integer> entry: contagemPeriodos.entrySet()) {
            List<Character> periodo = frequencias.get(entry.getValue());
            if (periodo == null) {
                periodo = new ArrayList<Character>();
            }
            periodo.add(entry.getKey());
            frequencias.put(entry.getValue(), periodo);
        }

        var periodoMaisFrequentado = frequencias.get(frequencias.lastKey());
        System.out.print("\nO elevador mais frequentado é " + elevadorMaisFrequentado + " e é mais utilizado" +
                " no turno " + periodoMaisFrequentado.get(0));

        return periodoMaisFrequentado;
    }

    @Override
    public List<Character> elevadorMenosFrequentado() {
        List<Character> elevadores = new ArrayList<>();
        this.elevadores.forEach(e -> elevadores.add(e.getElevador()));

        Map<Character, Integer> contagemAndares = new TreeMap<Character, Integer>();
        SortedMap<Integer, List<Character>> frequencias = new TreeMap<Integer, List<Character>>();

        for(char in: elevadores) {
            int freq = 0;
            if(contagemAndares.containsKey(in)) {
                freq = contagemAndares.get(in);
            }
            contagemAndares.put(in, freq + 1);
        }

        for(Map.Entry<Character, Integer> entry: contagemAndares.entrySet()) {
            List<Character> elevador = frequencias.get(entry.getValue());
            if (elevador == null) {
                elevador = new ArrayList<Character>();
            }
            elevador.add(entry.getKey());
            frequencias.put(entry.getValue(), elevador);
        }

        //System.out.println("\nElevadores menos frequentados: \n");
        var elevadoresMenosFrequentados = frequencias.get(frequencias.firstKey());
        //elevadoresMenosFrequentados.forEach(a -> System.out.print(a + " "));

        return elevadoresMenosFrequentados;
    }

    @Override
    public List<Character> periodoMenorFluxoElevadorMenosFrequentado() {
        var elevadorMenosFrequentado = this.elevadorMenosFrequentado().get(0);

        List<Character> periodos = new ArrayList<>();
        var turnos = this.elevadores.stream().filter(e -> e.getElevador() == elevadorMenosFrequentado)
                .collect(Collectors.toList());
        turnos.forEach(e -> periodos.add(e.getTurno()));

        Map<Character, Integer> contagemPeriodos = new TreeMap<Character, Integer>();
        SortedMap<Integer, List<Character>> frequencias = new TreeMap<Integer, List<Character>>();

        for(char in: periodos) {
            int freq = 0;
            if(contagemPeriodos.containsKey(in)) {
                freq = contagemPeriodos.get(in);
            }
            contagemPeriodos.put(in, freq + 1);
        }

        for(Map.Entry<Character, Integer> entry: contagemPeriodos.entrySet()) {
            List<Character> periodo = frequencias.get(entry.getValue());
            if (periodo == null) {
                periodo = new ArrayList<Character>();
            }
            periodo.add(entry.getKey());
            frequencias.put(entry.getValue(), periodo);
        }

        var periodoMenosFrequentado = frequencias.get(frequencias.firstKey());
        System.out.print("\nO elevador menos frequentado é " + elevadorMenosFrequentado + " e é menos utilizado" +
                " no turno " + periodoMenosFrequentado.get(0));

        return periodoMenosFrequentado;
    }

    @Override
    public List<Character> periodoMaiorUtilizacaoConjuntoElevadores() {
        List<Character> periodos = new ArrayList<>();
        this.elevadores.forEach(e -> periodos.add(e.getTurno()));

        Map<Character, Integer> contagemPeriodos = new TreeMap<Character, Integer>();
        SortedMap<Integer, List<Character>> frequencias = new TreeMap<Integer, List<Character>>();

        for(char in: periodos) {
            int freq = 0;
            if(contagemPeriodos.containsKey(in)) {
                freq = contagemPeriodos.get(in);
            }
            contagemPeriodos.put(in, freq + 1);
        }

        for(Map.Entry<Character, Integer> entry: contagemPeriodos.entrySet()) {
            List<Character> periodo = frequencias.get(entry.getValue());
            if (periodo == null) {
                periodo = new ArrayList<Character>();
            }
            periodo.add(entry.getKey());
            frequencias.put(entry.getValue(), periodo);
        }

        var periodoMaiorUtilizacao = frequencias.get(frequencias.lastKey());
        System.out.println("\nO período de maior utilização é " + periodoMaiorUtilizacao.get(0));

        return periodoMaiorUtilizacao;
    }

    @Override
    public float percentualDeUsoElevadorA() {
        var percentual = this.calculaPercentual('A');
        return percentual;
    }

    @Override
    public float percentualDeUsoElevadorB() {
        var percentual = this.calculaPercentual('B');
        return percentual;
    }

    @Override
    public float percentualDeUsoElevadorC() {
        var percentual = this.calculaPercentual('C');
        return percentual;
    }

    @Override
    public float percentualDeUsoElevadorD() {
        var percentual = this.calculaPercentual('D');
        return percentual;
    }

    @Override
    public float percentualDeUsoElevadorE() {
        var percentual = this.calculaPercentual('E');
        return percentual;
    }

    private float calculaPercentual(char elevador) {
        List<Character> elevadores = new ArrayList<>();
        this.elevadores.forEach(e -> elevadores.add(e.getElevador()));

        List<Character> elevadorEscolhido = elevadores.stream().filter(i -> i == elevador).collect(Collectors.toList());
        var percentual = (float)elevadorEscolhido.size() / elevadores.size() * 100;
        return percentual;
    }
}
