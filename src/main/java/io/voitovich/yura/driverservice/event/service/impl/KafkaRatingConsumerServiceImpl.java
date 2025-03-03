package io.voitovich.yura.driverservice.event.service.impl;

import io.voitovich.yura.driverservice.event.model.ConfirmRatingReceiveModel;
import io.voitovich.yura.driverservice.event.model.ReceiveRatingModel;
import io.voitovich.yura.driverservice.event.service.KafkaConfirmRatingReceiveService;
import io.voitovich.yura.driverservice.event.service.KafkaRatingConsumerService;
import io.voitovich.yura.driverservice.service.RatingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaRatingConsumerServiceImpl implements KafkaRatingConsumerService {

    private final RatingService ratingService;
    private final KafkaConfirmRatingReceiveService service;
    @Override
    public void consumeRating(ReceiveRatingModel model) {
        log.info("Received message from Kafka. Processing rating for driver with model: {}",
                model);
        ratingService.saveAndRecalculateRating(model);
        service.confirmRatingReceive(ConfirmRatingReceiveModel.builder()
                .rideId(model.rideId())
                .rating(model.rating())
                .build());
    }
}
