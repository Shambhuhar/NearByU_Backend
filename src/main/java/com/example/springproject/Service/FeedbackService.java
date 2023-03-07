package com.example.springproject.Service;

import java.util.List;
import java.util.Optional;

import com.example.springproject.Beans.Feedback;
import com.example.springproject.Dao.FeedbackDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	public List<Feedback> displayAll() {
		return feedbackDao.findAll();
	}

	public Optional<Feedback> getById(int id) {
		Optional<Feedback> op = feedbackDao.findById(id);
		if (op.isPresent()) {
			return op;
		} else {
			return Optional.empty();
		}
	}

	public Feedback addFeedback(Feedback p) {
		try {
			return feedbackDao.save(p);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public Feedback updateById(Feedback p) {
		Optional<Feedback> p1 = feedbackDao.findById(p.getId());
		if (p1.isPresent()) {
			Feedback p2 = p1.get();
			p2.setCustomer(p.getCustomer());
			p2.setWorker(p.getWorker());
			p2.setComment(p.getComment());
			p2.setRating(p.getRating());

			return feedbackDao.save(p2);

		} else {
			return null;
		}
	}

	public void deleteById(int id) {
		feedbackDao.deleteById(id);

	}

}
