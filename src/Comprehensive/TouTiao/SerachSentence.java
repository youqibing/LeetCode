package Comprehensive.TouTiao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 问题描述】给定一个段落，由 N 个句子组成。第 i 个句子的长度为 L[i]，包含的单词个数为 W[i]。句子不包含任何除字母和空格( ) 外的符号。
 每个句子内部，含有若干个单词，由空格( ) 分隔。句子不会包含连续的空格。
 随后给定 M 个查询，每个查询包含一个句子，需要在段落中寻找相同单词数量最多的句子。重复的单词只计一次，且不区分大小写。
 输入数据将保证结果是存在且唯一的。

 输入格式
 第一行是两个整数 N 和 M。
 接下来的 N+M 行，每行包含一个句子。
 前 N 行代表段落中的句子，后 M 行表示查询。
 输出格式
 输出 M 行，每行代表查询的结果。

 输入样例
 6 3
 An algorithm is an effective method that can be expressed within a finite amount of space and time
 Starting from an initial state and initial input the instructions describe a computation
 That when executed proceeds through a finite number of successive states
 Eventually producing output and terminating at a final ending state
 The transition from one state to the next is not necessarily deterministic
 Some algorithms known as randomized algorithms incorporate random input

 Next to the transition
 Wormhole, infinite time and space
 The transition from one state to the next is not necessarily deterministic

 输出样例
 The transition from one state to the next is not necessarily deterministic
 An algorithm is an effective method that can be expressed within a finite amount of space and time
 The transition from one state to the next is not necessarily deterministic

 数据规模
 0 < L[i] < 512
 0 < W[i] < 32

 对于 30% 的数据，0 < N < 30，0 < M < 30。
 对于 100% 的数据，0 < N < 500，0 < M < 800。
 */
public class SerachSentence {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        in.nextLine();

        String[] sentences = new String[N];
        for(int i=0; i<N; i++){
            sentences[i] = in.nextLine();
        }

        String[] serach = new String[M];
        for(int i=0; i<M; i++){
            serach[i] = in.nextLine();
        }

        List<HashSet<String>> sentenceList = new ArrayList<>();
        for(int i=0; i<N; i++){
            HashSet<String> set = new HashSet<>();
            String[] temp = sentences[i].toLowerCase().split(" ");
            for(String s : temp){
                set.add(s);
            }
            sentenceList.add(set);
        }

        //List<HashSet<String>> serachList = new ArrayList<>();
        for(int i=0; i<M; i++){
            HashSet<String> set = new HashSet<>();
            String[] temp = serach[i].toLowerCase().split(" ");
            for(String s: temp){
                set.add(s);
            }

            int max =0;
            int maxIndex =0;
            for(int j=0; j<N; j++){
                int count =0;

                HashSet<String> sentence = sentenceList.get(j);
                for(String s: set){
                    if(sentence.contains(s)){
                        count++;
                    }
                }

                if(count > max){
                    max = count;
                    maxIndex = j;
                }

            }

            System.out.println(sentences[maxIndex]);
        }


    }
}
