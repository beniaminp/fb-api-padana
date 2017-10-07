package com.padana.fb.models

import java.util.Date

import play.api.libs.json.Json

sealed trait Profile {}


case class Location(city: Option[String], country: Option[String], latitude: Option[Double], longitude: Option[Double], state: Option[String], zip: Option[String])

object Location {
  implicit val locationJsonFormat = Json.format[Location]
}

case class Place(name: Option[String], location: Option[Location], id: Option[String])

object Place {
  implicit val placeJsonFormat = Json.format[Place]
}


case class Album(link: Option[String], name: Option[String], place: Option[Place], privacy: Option[String], id: Option[String])

object Album {
  implicit val albumJsonFormat = Json.format[Album]
}

case class CoverPhoto(id: String, offset_x: Option[Float], offset_y: Option[Float], source: Option[String])

object CoverPhoto {
  implicit val coverPhotoJsonFormat = Json.format[CoverPhoto]
}


case class PlatformImageSource(height: Option[Int], source: Option[String], width: Option[Int])

object PlatformImageSource {
  implicit val platImageSourceJsonFormat = Json.format[PlatformImageSource]
}


case class EntityAtTextRange(id: String, length: Option[Int], name: Option[String], _object: Option[Profile], offset: Option[Int], _type: Option[Enumeration])

object EntityAtTextRange {
  implicit val entitAtTextRangeJsonFormat = Json.format[EntityAtTextRange]
}

case class Group(id: String, cover: Option[CoverPhoto], description: Option[String], email: Option[String], icon: Option[String], member_request_count: Option[Int],
                 name: Option[String], owner: Profile, parent: Profile, privacy: Option[String], updated_time: Option[Date]) extends Profile

object Group {
  implicit val groupJsonFormat = Json.format[Group]
}

case class Event(id: String, attending_count: Option[Int], can_guests_invite: Option[Boolean], can_viewer_post: Option[Boolean], category: Option[String], cover: Option[CoverPhoto],
                 declined_count: Option[Int], description: Option[String], end_time: Option[String], event_times: Option[List[Event]], guest_list_enabled: Option[Boolean],
                 interested_coun: Option[Int], is_canceled: Option[Boolean], is_draft: Option[Boolean], is_page_owned: Option[Boolean], is_viewer_admin: Option[Boolean],
                 maybe_count: Option[Int], name: Option[String], noreply_count: Option[Int], owner: Option[Profile], parent_group: Option[Group], place: Option[Place], start_time: Option[String],
                 ticket_uri: Option[String], ticketing_privacy_uri: Option[String], ticketing_terms_uri: Option[String], timezone: Option[Enumeration], _type: Option[Enumeration],
                 updated_time: Option[Date]) extends Profile

object Event {
  implicit val jsonFormat = Json.format[Event]
}

case class Photo(id: String, album: Option[Album], backdated_time: Option[String], can_backdate: Option[Boolean], can_delete: Option[Boolean], can_tag: Option[Boolean],
                 created_time: Option[Date], event: Option[Event], from: Option[String], height: Option[Int], icon: Option[String], images: Option[List[PlatformImageSource]],
                 link: Option[String], name: Option[String], name_tags: Option[List[EntityAtTextRange]], page_story_id: Option[String], picture: Option[String],
                 place: Option[Place], target: Option[Profile], updated_time: Option[Date], webp_images: Option[List[PlatformImageSource]], width: Option[Int])

object Photo {
  implicit val photoJsonFormat = Json.format[Photo]
}

case class Page() extends Profile

object Page {
  implicit val pageJsonFormat = Json.format[Page]
}

case class App() extends Profile

object App {
  implicit val appJsonFormat = Json.format[App]
}

case class PageAdminNote(id: String, body: Option[String], from: Option[Page], user: Option[User])

object PageAdminNote {
  implicit val jsonFormat = Json.format[PageAdminNote]
}

case class AgeRange(max: Option[Int], min: Option[Int])

object AgeRange {
  implicit val jsonFormat = Json.format[AgeRange]
}

case class UserContext(id: String)

object UserContext {
  implicit val jsonFormat = Json.format[UserContext]
}

case class Currency(currency_offset: Option[Int], usd_exchange: Option[Float], usd_exchange_inverse: Option[Float], user_currency: Option[String])

object Currency {
  implicit val jsonFormat = Json.format[Currency]
}

case class UserDevice(hardware: Option[String], os: Option[String])

object UserDevice {
  implicit val jsonFormat = Json.format[UserDevice]
}

case class EducationExperience(id: String, classes: Option[List[Education]], concentration: Option[List[Page]], degree: Option[Page], school: Option[Page],
                               _type: Option[String], _with: Option[List[User]], year: Option[Page])

object EducationExperience {
  implicit val jsonFormat = Json.format[EducationExperience]
}

case class Education(id: String, description: Option[String], from: Option[User], name: Option[String], _with: Option[List[User]])

object Education {
  implicit val jsonFormat = Json.format[Education]
}

case class Experience(id: String, description: Option[String], from: Option[User], name: Option[String], _with: Option[List[User]])

object Experience {
  implicit val jsonFormat = Json.format[Experience]
}

case class PageLabel(id: String, creation_time: Option[Date], creator_id: Option[Profile], from: Option[Page], name: Option[String])

object PageLabel {
  implicit val jsonFormat = Json.format[PageLabel]
}

case class PaymentPricepoint(credits: Option[Float], local_currency: Option[String], user_price: Option[String])

object PaymentPricepoint {
  implicit val jsonFormat = Json.format[PaymentPricepoint]
}

case class PaymentPricepoints(mobile: Option[List[PaymentPricepoint]])

object PaymentPricepoints {
  implicit val jsonFormat = Json.format[PaymentPricepoints]
}

case class SecureBrowsing(enabled: Option[Boolean])

object SecureBrowsing {
  implicit val jsonFormat = Json.format[SecureBrowsing]
}

case class SecuritySettings(secure_browsing: Option[SecureBrowsing])

object SecuritySettings {
  implicit val jsonFormat = Json.format[SecuritySettings]
}

case class ViewoUploadLimits(length: Option[Int], size: Option[Int])

object ViewoUploadLimits {
  implicit val jsonFormat = Json.format[ViewoUploadLimits]
}

case class User(id: String, about: Option[String], admin_notes: Option[List[PageAdminNote]], age_range: Option[AgeRange], birthday: Option[String],
                can_review_measurement_request: Option[Boolean], context: Option[UserContext], cover: Option[CoverPhoto], currency: Option[Currency],
                devices: List[Option[UserDevice]], education: Option[List[EducationExperience]], email: Option[String], employee_number: Option[String],
                favorite_athletes: Option[List[Experience]], favorite_teams: Option[List[Experience]], first_name: Option[String], gender: Option[String],
                hometown: Option[Page], inspirational_people: Option[List[Experience]], install_type: Option[Enumeration], installed: Option[Boolean],
                interested_in: Option[String], is_payment_enabled: Option[Boolean], is_shared_login: Option[Boolean], is_verified: Option[Boolean],
                labels: Option[List[PageLabel]], languages: Option[List[Experience]], last_name: Option[String], link: Option[String], locale: Option[String],
                location: Option[Page], meeting_for: Option[List[String]], middle_name: Option[String], name: Option[String], name_format: Option[String],
                payment_pricepoints: Option[PaymentPricepoints], political: Option[String], profile_pic: Option[String], public_key: Option[String], quotes: Option[String],
                relationship_status: Option[String], religion: Option[String], security_settings: Option[SecuritySettings], shared_login_upgrade_required_by: Option[Date],
                short_name: Option[String], significant_other: Option[User], sports: Option[List[Experience]], test_group: Option[Int], third_party_id: Option[String],
                timezone: Option[Float], token_for_business: Option[String], updated_time: Option[Date], verified: Option[Boolean], video_upload_limits: Option[ViewoUploadLimits],
                viewer_can_send_gift: Option[Boolean], website: Option[String], work: Option[List[WorkExperience]]) extends Profile

object User {
  implicit val userJsonFormat = Json.format[User]
}

case class ProjectExperience(id: String, description: Option[String], end_date: Option[String], from: Option[User], name: Option[String], start_date: Option[String], _with: Option[List[User]])

object ProjectExperience {
  implicit val jsonFormat = Json.format[ProjectExperience]
}

case class WorkExperience(id: String, description: Option[String], employer: Option[Page], end_date: Option[String], from: Option[User], location: Option[Page],
                          position: Option[Page], projects: Option[List[ProjectExperience]], start_date: Option[String], _with: Option[List[User]])

object WorkExperience {
  implicit val jsonFormat = Json.format[WorkExperience]
}