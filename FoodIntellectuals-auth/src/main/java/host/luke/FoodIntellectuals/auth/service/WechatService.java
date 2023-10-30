package host.luke.FoodIntellectuals.auth.service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import host.luke.FoodIntellectuals.auth.entity.dto.GetUnionIdDTO;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WechatService {

  @Value("${wechat.app-id}")
  private String appId;
  @Value("${wechat.app-secret}")
  private String appSecret;
  @Value("${wechat.get-union-id-url}")
  private String getUnionIdUrl;

  final String grantType = "authorization-code";

  public GetUnionIdDTO getUnionIdByJsCode(String jsCode) {

    Map<String, Object> params = new HashMap();
    params.put("appid", appId);
    params.put("secret", appSecret);
    params.put("js_code", jsCode);
    params.put("grant_type", grantType);

    String response = HttpUtil.get(getUnionIdUrl, params);
    GetUnionIdDTO getUnionIdDTO = JSONUtil.toBean(response, GetUnionIdDTO.class);
    return getUnionIdDTO;
  }


}