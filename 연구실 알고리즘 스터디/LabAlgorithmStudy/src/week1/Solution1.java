package week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.*;

// 프로그래머스 신고 결과 받기
public class Solution1 {
    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;


        int[] answer = solution(id_list, report, k);
        for (int i = 0; i < id_list.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        Hashtable<String, Member> members = new Hashtable<>();
        ArrayList<Member> membersTmp = new ArrayList<>();

        // 1. Member들 생성
        for(String str : id_list){
            Member m = new Member(str, k);
            members.put(str, m);
            membersTmp.add(m);
        }

        // 2. Set으로 중복report제거 후, 메인 로직 실행

        HashSet<String> reportSet = new HashSet<>();
        for(String str : report){
            reportSet.add(str);
        }

        for(String str : reportSet){
            //StringTokenizer로 hitter(신고자)와 getter(피신고자)로 저장
            //getter.warned(hitter);
            StringTokenizer st = new StringTokenizer(str);
            Member hitter = members.get(st.nextToken());
            Member getter = members.get(st.nextToken());

            // getter가 hitter로부터 신고받음
            getter.warned(hitter);
        }
        // 신고를 k번 이상 받은 Member들은 reporter들에게 메일 발송
        for(Member m : membersTmp){
            m.sendMail();
        }

        // 3. 마지막으로 각 Member들이 mail받은 횟수 return
        // (id_list순서대로)answer에 members.mailN을 담아서 return
        int[] answer = new int[id_list.length];
        for(int i = 0; i < id_list.length; i++){
            answer[i] = members.get(id_list[i]).mailN;
        }

        return answer;
    }

    static class Member{
        String name;
        int k;
        int mailN;
        int warnedN;
        ArrayList<Member> reporters;

        Member(String name, int k){
            this.name = name;
            this.k = k;
            reporters = new ArrayList<>();
        }

        void mailed(){
            mailN++;
        }

        void warned(Member reporter){
            warnedN++;
            reporters.add(reporter);
        }

        void sendMail(){
            if(warnedN >= k){
                for(Member m : reporters){
                    m.mailed();
                }
            }
        }

    }
}
