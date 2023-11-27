package host.luke.FoodIntellectuals.biz.controller;

import host.luke.FoodIntellectuals.common.dto.FoodRankItem;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;
import host.luke.FoodIntellectuals.rank.service.RankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rank")
public class RankController {
  private final RankService rankService;
  public RankController(RankService rankService) {
    this.rankService = rankService;
  }
  @GetMapping("/list/hot")
  private ResponseDto<List<FoodRankItem>> getRankListByHotValue() {
    return rankService.getRankListByHotValue();
  }
}
