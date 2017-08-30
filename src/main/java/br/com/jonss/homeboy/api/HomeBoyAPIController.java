package br.com.jonss.homeboy.api;

import br.com.jonss.homeboy.model.RegisterType;
import br.com.jonss.homeboy.model.WorkRegister;
import br.com.jonss.homeboy.repository.WorkRegisterRepository;
import br.com.jonss.homeboy.util.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static br.com.jonss.homeboy.model.RegisterType.FLW;
import static br.com.jonss.homeboy.model.RegisterType.WFH;
import static br.com.jonss.homeboy.model.RegisterType.XOVE;

@RestController
public class HomeBoyAPIController {

    Logger LOG = LoggerFactory.getLogger(HomeBoyAPIController.class);

    @Autowired
    private WorkRegisterRepository workRegisterRepository;

    @PostMapping("/homeboy")
    public String index(@RequestBody MultiValueMap paramMap) {
        String text = cleanValue(paramMap.get("text")).toUpperCase();
        String userName = cleanValue(paramMap.get("user_name"));
        LOG.info(String.format("Command %s from %s", text, userName));

        if(!WFH.toString().equals(text) && !FLW.toString().equals(text) && !XOVE.toString().equals(text)) {
            System.out.println(WFH.toString().equals(text));
            System.out.println(FLW.toString().equals(text));
            return "Não conheço o que você disse, ainda tô aprendendo. Mande WFH ou FLW por favor.";
        }

        String userId = paramMap.get("user_id").toString();

        if(text.equals(WFH.toString())) {
            WorkRegister workRegister = new WorkRegister(
                    userName,
                    userId,
                    TimeUtil.nowInSaoPaulo(),
                    RegisterType.valueOf(text));

            workRegisterRepository.save(workRegister);

            return String.format("Home office registrado %s!", workRegister.getUserName());
        }

        if(text.equals(FLW.toString())) {
            WorkRegister workRegister = workRegisterRepository.findTop1ByUserId(userId);
            workRegister.setDepartureTime(TimeUtil.nowInSaoPaulo());
            workRegisterRepository.save(workRegister);
            return String.format("Saída registrada, %s. Até amanhã.", workRegister.getUserName());
        }

        if(text.equals(XOVE.toString())) {
            List<WorkRegister> allByUserName = workRegisterRepository.findAllByUserName(userName);
            return allByUserName.toString();
        }

        return "";
    }

    private String cleanValue(Object valueMap) {
        return valueMap.toString()
                .replaceAll("]", "")
                .replaceAll("\\[", "").trim();
    }

}
