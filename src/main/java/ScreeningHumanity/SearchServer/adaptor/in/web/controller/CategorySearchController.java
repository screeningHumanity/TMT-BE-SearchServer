package ScreeningHumanity.SearchServer.adaptor.in.web.controller;

import ScreeningHumanity.SearchServer.application.port.in.usecase.CategorySearchUseCase;
import ScreeningHumanity.SearchServer.application.port.out.outvo.CategoryOutVo;
import ScreeningHumanity.SearchServer.global.common.response.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "Category 조회 API", description = "Category 조회 관련 API")
public class CategorySearchController {

    private final CategorySearchUseCase categorySearchUseCase;

    @Operation(summary = "Main Category 조회 api", description = "Main Category 조회 API")
    @GetMapping("/categories")
    private BaseResponse<List<CategoryOutVo.MainCategory>> searchMainCategory(){
        List<CategoryOutVo.MainCategory> findData = categorySearchUseCase.searchMainCategory();

        return new BaseResponse<>(findData);
    }

    @Operation(summary = "Sub Category 조회 api", description = "Main Category Id로 Sub Category 리스트를 조회 합니다.")
    @GetMapping("/maincategories/{mainCategoryId}/subcategory")
    private BaseResponse<CategoryOutVo.ResponseSubCategory> searchSubCategoryByMainCategoryId(
            @PathVariable(value = "mainCategoryId") String mainCategoryId
    ){
        CategoryOutVo.ResponseSubCategory responseSubCategory = categorySearchUseCase.searchSubCategory(
                mainCategoryId);

        return new BaseResponse<>(responseSubCategory);
    }

    @Operation(summary = "Sub Category 의 종목 조회 api", description = "Category Id로 종목의 리스트를 조회 합니다.")
    @GetMapping("/subcategories/{subCategoryId}/items")
    private BaseResponse<CategoryOutVo.ResponseStockList> searchStocksBySubCategoryId(
            @PathVariable(value = "subCategoryId") String subCategoryId
    ){
        CategoryOutVo.ResponseStockList findData = categorySearchUseCase.searchStockListByCategory(
                subCategoryId);
        return new BaseResponse<>(findData);
    }
}
