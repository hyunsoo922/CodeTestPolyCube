package kr.co.polycube.backendtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class LottoService {

    private final static int[] WINNER_NUMBER = {15,29,38,6,44,21};

    @Autowired
    private LottoRepository lottoRepository;

    @Autowired
    private WinnerRepository winnerRepository;

    public void defaultLotto()
    {
        Lotto lotto1 = Lotto.builder()
                .number_1(7)
                .number_2(28)
                .number_3(33)
                .number_4(2)
                .number_5(45)
                .number_6(19)
                .build();

        Lotto lotto2 = Lotto.builder()
                .number_1(26)
                .number_2(14)
                .number_3(41)
                .number_4(3)
                .number_5(22)
                .number_6(35)
                .build();

        Lotto lotto3 = Lotto.builder()
                .number_1(15)
                .number_2(29)
                .number_3(38)
                .number_4(6)
                .number_5(44)
                .number_6(21)
                .build();

        Lotto lotto4 = Lotto.builder()
                .number_1(31)
                .number_2(16)
                .number_3(42)
                .number_4(9)
                .number_5(23)
                .number_6(36)
                .build();

        Lotto lotto5 = Lotto.builder()
                .number_1(17)
                .number_2(30)
                .number_3(39)
                .number_4(10)
                .number_5(45)
                .number_6(24)
                .build();

        lottoRepository.saveAndFlush(lotto1);
        lottoRepository.saveAndFlush(lotto2);
        lottoRepository.saveAndFlush(lotto3);
        lottoRepository.saveAndFlush(lotto4);
        lottoRepository.saveAndFlush(lotto5);
    }

    public Lotto createLotto()
    {
        Set<Integer> lottoNumbers = LottoIssuance.createLotto();
        List<Integer> lottoNum = lottoNumbers.stream().toList();

        int[] number = new int[6];

        for(int i = 0; i < 6 ; i++)
        {
            number[i] = lottoNum.get(i);
        }

        Lotto lotto = Lotto.builder()
                .number_1(number[0])
                .number_2(number[1])
                .number_3(number[2])
                .number_4(number[3])
                .number_5(number[4])
                .number_6(number[5])
                .build();

        lottoRepository.saveAndFlush(lotto);
        return lotto;
    }

    public Winner ranking(Long id)
    {
        Lotto lotto = lottoRepository.findById(id).orElse(null);
        System.out.println(lotto);
        int count = 0;
        for(int i = 0 ; i < 6 ; i++)
        {
            if(lotto.getNumber_1() == WINNER_NUMBER[i])
            {
                count++;
            }
            if(lotto.getNumber_2() == WINNER_NUMBER[i])
            {
                count++;
            }
            if(lotto.getNumber_3() == WINNER_NUMBER[i])
            {
                count++;
            }
            if(lotto.getNumber_4() == WINNER_NUMBER[i])
            {
                count++;
            }
            if(lotto.getNumber_5() == WINNER_NUMBER[i])
            {
                count++;
            }
            if(lotto.getNumber_6() == WINNER_NUMBER[i])
            {
                count++;
            }
        }

        Winner winner = null;
        System.out.println(count);
        switch(count)
        {
            case 6:
                winner = Winner.builder()
                        .lotto(lotto)
                        .rank(1)
                        .build();
                break;
            case 5:
                winner = Winner.builder()
                        .lotto(lotto)
                        .rank(2)
                        .build();
                break;
            case 4:
                winner = Winner.builder()
                        .lotto(lotto)
                        .rank(3)
                        .build();
                break;
            case 3:
                winner = Winner.builder()
                        .lotto(lotto)
                        .rank(4)
                        .build();
                break;
            case 2:
                winner = Winner.builder()
                        .lotto(lotto)
                        .rank(5)
                        .build();
                break;
            default:
                winner = Winner.builder()
                        .lotto(lotto)
                        .rank(6)
                        .build();
        }

        winnerRepository.saveAndFlush(winner);
        return winner;
    }


}
