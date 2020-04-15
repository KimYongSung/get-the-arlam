package com.arlam.app.mapper;

/**
 * JPA Entity와 DTO 매핑 처리
 * @param <E> Entity 클래스 정보
 * @param <D> DTO 클래스 정보
 */
public interface EntityMapper<E, D> {

    /**
     * DTO를 Entity로 변환
     * @param dto DTO 객체
     * @return Entity 객체
     */
    E toEntity(D dto);

    /**
     * Entity를 DTO로 변환
     * @param entity entity 객체
     * @return DTO 객체
     */
    D toDto(E entity);
}
