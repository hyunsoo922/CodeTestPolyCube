package kr.co.polycube.backendtest;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoIssuance {
    public static Set<Integer> createLotto(){
        Set<Integer> lottoNumbers = new HashSet<>();
        Random random = new Random();

        for(int i = 0 ; i < 6; i++)
        {
            lottoNumbers.add(random.nextInt(45)+1);
        }

        return lottoNumbers;

    }
}
