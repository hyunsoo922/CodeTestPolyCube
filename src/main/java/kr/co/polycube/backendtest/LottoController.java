package kr.co.polycube.backendtest;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class LottoController {

    @Autowired
    private LottoService lottoService;

    @PostConstruct
    public void start()
    {
        lottoService.defaultLotto();
    }
    @PostMapping("/lottos")
    public LottoResponse takeLotto()
    {
        Lotto lotto = lottoService.createLotto();
        Integer[] numbers = {lotto.getNumber_1(), lotto.getNumber_2(),
                lotto.getNumber_3(), lotto.getNumber_4(),
                lotto.getNumber_5(), lotto.getNumber_6()};
        return new LottoResponse(numbers);
    }

    @PostMapping("/lottos/{id}")
    public WinnerResponse winLotto(@PathVariable Long id)
    {
        Winner winner = lottoService.ranking(id);
        return new WinnerResponse(id,winner.getRank());
    }





}
