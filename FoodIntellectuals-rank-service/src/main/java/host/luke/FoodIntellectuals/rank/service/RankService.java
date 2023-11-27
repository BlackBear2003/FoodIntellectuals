package host.luke.FoodIntellectuals.rank.service;

import host.luke.FoodIntellectuals.common.dto.FoodRankItem;
import host.luke.FoodIntellectuals.common.dto.ResponseDto;

import java.util.List;

public interface RankService {
  ResponseDto<List<FoodRankItem>> getRankListByHotValue();

  ResponseDto<List<FoodRankItem>> getRankListByLikeNum();
}
