package service;

//Программа Java для поиска одного источника на самых больших расстояниях
//в DAG

import java.util.*;

class GFG {
    //График представлен с помощью списка смежности. Каждый
    //узел списка смежности содержит номер вершины
    // вершины, с которой соединяется ребро. Это также
    //содержит вес ребра
    static class AdjListNode {
        int v;
        Double weight;
        String infa;

        AdjListNode(int _v, Double _w, String _infa) {
            v = _v;
            weight = _w;
            infa = _infa;
        }

        int getV() {
            return v;
        }

        Double getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "AdjListNode{" +
                    "v=" + v +
                    ", weight=" + weight +
                    ", infa='" + infa + '\n' +
                    '}';
        }
    }

    //Класс для представления графика с использованием списка смежности
    // представительство
    static class Graph {
        int V; // Количество вершин

        //Указатель на массив, содержащий списки смежности
        ArrayList<ArrayList<AdjListNode>> adj = new ArrayList<>(V);  // adj = new ArrayList<ArrayList<AdjListNode>>(V);

        @Override
        public String toString() {
            return "Graph{" +
                    "V=" + V +
                    ", adj=" + adj.toString() +
                    '}';
        }

        Graph(int V) // Конструктор тут задаем количество вершин
        {
            this.V = V;
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        //добавляем ребро
        void addEdge(int u, int v, Double weight, String infa) {
            AdjListNode node = new AdjListNode(v, weight, infa);
            adj.get(u).add(node); // Добавить v в список u
            //System.out.println("Информация о каждом ребре : " + infa + " u = " + u + " v = " + v + " weight: " + weight);
        }

        //// Рекурсивная функция, используемая самым длинным путем. Смотреть ниже
        //ссылка для получения подробной информации
        // https:// www.geeksforgeeks.org/topological-sorting/
        void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
            //Отметьте текущий узел как посещенный
            visited[v] = true;

            //Повторяется для всех вершин, смежных с этой вершиной
            for (int i = 0; i < adj.get(v).size(); i++) {
                AdjListNode node = adj.get(v).get(i);
                if (!visited[node.getV()])
                    topologicalSortUtil(node.getV(), visited, stack);
            }

            //Переместить текущую вершину в стек на вершину, в котором хранятся топологические
            // сортировать
            stack.push(v);
        }

        // Функция для нахождения наибольших расстояний от заданной вершины.
        ////Он использует рекурсивную топологическую сортировку Util() для получения топологической
        // сортировка.
        void longestPath(int s) {
            Stack<Integer> stack = new Stack<>(); // создаем пустой стек
            int dist[] = new int[V]; //массив из вершин графа

            //Отметьте все вершины как не посещенные
            boolean visited[] = new boolean[V];
            for (int i = 0; i < V; i++) {
                visited[i] = false;
            }

            //Вызовите рекурсивную вспомогательную функцию для хранения топологических
            //Сортировка, начиная со всех вершин по одной
            for (int i = 0; i < V; i++) {
                if (visited[i] == false) {
                    topologicalSortUtil(i, visited, stack);
                }
            }
            //Инициализируйте расстояния до всех вершин как бесконечные и
            //расстояние до источника как 0
            for (int i = 0; i < V; i++) {
                dist[i] = Integer.MIN_VALUE;
            }

            dist[s] = 0;

            // Обрабатывайте вершины в топологическом порядке
            while (stack.isEmpty() == false) {

                // Обрабатывать вершины в топологическом порядке
                int u = stack.peek();//используется для извлечения или извлечения первого элемента стека или элемента, находящегося в верхней части стека
                stack.pop();//используется для извлечения элемента из стека. Элемент выталкивается с вершины стека и удаляется из него.

                // Обновить расстояния всех соседних вершин ;
                if (dist[u] != Integer.MIN_VALUE) {
                    for (int i = 0; i < adj.get(u).size(); i++) {
                        AdjListNode node = adj.get(u).get(i);
                        if (dist[node.getV()] < dist[u] + node.getWeight()) {
                            dist[node.getV()] = (int) (dist[u] + node.getWeight());
                        }
                    }
                }
            }

            // Выведите рассчитанные самые длинные расстояния
            for (int i = 0; i < V; i++) {
                if (dist[i] == Integer.MIN_VALUE) {
                    System.out.println(i + ") " + "INF ");
                } else if (dist[i] > 0) {   // Ставим ограничение тут
                    System.out.println(i + ") " + "Вывод самых результативых путей " + dist[i] + " . ");
                } else {
                    //System.out.println(" else ");
                    if (dist[i] != 0) {
                        System.out.println(i + ") " + "Вывод всех путей : " + dist[i]);
                    }
                }
            }
            System.out.println("===========================");
            int maximum = dist[0];
            for (int i = 0; i < V; i++) {
                if (dist[i] > maximum) {
                    maximum = dist[i];
                }
            }
            System.out.println("Максимум = " + maximum);
            int minimum = dist[0];
            for (int i = 0; i < V; i++) {
                if (dist[i] < minimum) {
                    minimum = dist[i];
                }
            }
            System.out.println("Минимум = " + minimum);
            System.out.println("Среднее между максимум и минимумом: " + ((maximum + minimum) / 2));
            double eff = maximum * 0.55;
            System.out.println("Зададим 55% эффективности : " + eff);
            System.out.println("=============================");
            System.out.println("Окончательный вывод: ");
            for (int i = 0; i < V; i++) {
                if (dist[i] > eff) {
                    System.out.println(i + ") " + "Вывод самых результативых путей " + dist[i] + " . ");

                }
            }
        }
    }

    //Программа драйвера для тестирования вышеуказанных функций
    public static void main(String args[]) {
        // Создайте график, приведенный на приведенной выше диаграмме.
        //Здесь номера вершин 0, 1, 2, 3, 4, 5 с
        //следующие сопоставления:
        //0=r, 1=s, 2=t, 3=x, 4=y, 5=z
        // Graph g = new Graph(10);


      /*  g.addEdge(0, 1, (double) 111, "1-ый клиент");
        g.addEdge(0, 2, (double)222, "2-ой клиент");
        g.addEdge(0, 3, (double)667, "3-ий клиент");
        g.addEdge(0, 4, (double)999, "4-ый клиент");
        g.addEdge(1, 5, (double)555, "5-ый клиент");
        g.addEdge(5, 6, (double)333, "6-ой клиент");
        g.addEdge(5, 7, (double)444, "7-ой клиент");
        g.addEdge(2, 8, (double)223, "8-ой клиент");
        g.addEdge(2, 9, (double)224, "9-ый клиент");*/
        /*
        g.addEdge(0, 1, 222);
        g.addEdge(0, 5, 999);
        g.addEdge(0, 2, 444);
        g.addEdge(1, 3, 333);
        g.addEdge(3, 4, 111);
        g.addEdge(0, 6, 1);

        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 2);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 2);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, -1);
        g.addEdge(4, 5, -2);
        */
/*
        int s = 0;
        System.out.print("Ниже приведены самые большие расстояния от исходной вершины " + s + " \n");

        g.longestPath(s);*/

    }
}